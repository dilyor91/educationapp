import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IAddmissionRules } from 'app/shared/model/addmission-rules.model';
import { getEntities } from './addmission-rules.reducer';

export const AddmissionRules = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const addmissionRulesList = useAppSelector(state => state.addmissionRules.entities);
  const loading = useAppSelector(state => state.addmissionRules.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="addmission-rules-heading" data-cy="AddmissionRulesHeading">
        <Translate contentKey="educationApp.addmissionRules.home.title">Addmission Rules</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="educationApp.addmissionRules.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/addmission-rules/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="educationApp.addmissionRules.home.createLabel">Create new Addmission Rules</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {addmissionRulesList && addmissionRulesList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.titleUz">Title Uz</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.titleRu">Title Ru</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.titleKr">Title Kr</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.contentUz">Content Uz</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.contentRu">Content Ru</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.contentKr">Content Kr</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.addmissionRules.status">Status</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {addmissionRulesList.map((addmissionRules, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/addmission-rules/${addmissionRules.id}`} color="link" size="sm">
                      {addmissionRules.id}
                    </Button>
                  </td>
                  <td>{addmissionRules.titleUz}</td>
                  <td>{addmissionRules.titleRu}</td>
                  <td>{addmissionRules.titleKr}</td>
                  <td>{addmissionRules.contentUz}</td>
                  <td>{addmissionRules.contentRu}</td>
                  <td>{addmissionRules.contentKr}</td>
                  <td>{addmissionRules.status ? 'true' : 'false'}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button
                        tag={Link}
                        to={`/addmission-rules/${addmissionRules.id}`}
                        color="info"
                        size="sm"
                        data-cy="entityDetailsButton"
                      >
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/addmission-rules/${addmissionRules.id}/edit`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/addmission-rules/${addmissionRules.id}/delete`}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="educationApp.addmissionRules.home.notFound">No Addmission Rules found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default AddmissionRules;
